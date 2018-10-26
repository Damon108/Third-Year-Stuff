fprintf('Testing dynamic array object.\n\n');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Creating...');
dynamic_array = create_dynamic_array();
fprintf('Success!\n\n');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Testing dynamic_array::to_matlab_array with empty array...');
assert(isequal(dynamic_array.to_matlab_array(),[]),...
['dynamic_array::to_matlab_array failed to return the empty array for a newly created element',...
'Hint: this may be due to indexing (what does array(1:0) return?)']);
fprintf('Success!\n\n');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Testing dynamic_array::push...');
dynamic_array.push(1);
dynamic_array.push(2);
dynamic_array.push(3);
assert(isequal(dynamic_array.to_matlab_array(),[1,2,3]));
fprintf('Success!\n\n');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Testing dynamic_array::set...');
dynamic_array.set(1,10);
dynamic_array.set(2,-5);
dynamic_array.set(3,4);
assert(isequal(dynamic_array.to_matlab_array(),[10,-5,4]),'dynamic_array::set failed.');
exception_thrown = false;
try
    dynamic_array.set(10,5);
catch err
    disp(err.identifier);
    exception_thrown = true;
end
assert(exception_thrown,'dynamic_array::set failed to generate an error for an index greater than its size');
exception_thrown = false;
try
    dynamic_array.set(0,5);
catch err
    disp(err.identifier);
    exception_thrown = true;
end
assert(exception_thrown,'dynamic_array::set failed to generate an error for an index less than 1');
fprintf('Success!\n\n');
    
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Testing dynamic_array::get...');
assert(dynamic_array.get(1)==10,'dynamic_array::get failed.');
exception_thrown = false;
try
    dynamic_array.get(7);
catch err
    disp(err.identifier);
    exception_thrown = true;
end
assert(exception_thrown,'dynamic_array::get failed to generate an error for an index greater than its size');
exception_thrown = false;
try
    dynamic_array.set(0);
catch err
    disp(err.identifier);
    exception_thrown = true;
end
assert(exception_thrown,'dynamic_array::get failed to generate an error for an index less than 1');
fprintf('Success!\n\n');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Testing dynamic_array::pop...');
dynamic_array.pop();
assert(isequal(dynamic_array.to_matlab_array(),[10,-5]),'dynamic_array::pop failed.');
dynamic_array.pop();
dynamic_array.pop();
assert(isequal(dynamic_array.to_matlab_array(),[]),'dynamic_array::pop failed.');
dynamic_array.pop();
assert(isequal(dynamic_array.to_matlab_array(),[]),'dynamic_array::pop failed on empty array.');
fprintf('Success!\n\n');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Testing dynamic_array::is_empty and dynamic_array::get_length...');
assert(dynamic_array.is_empty(),'dynamic_array::is_empty failed for empty array.');
assert(dynamic_array.get_length()==0,'dynamic_array::length failed for empty array.');
dynamic_array.push(5);
assert(~dynamic_array.is_empty(),'dynamic_array::is_empty failed for non-empty array.');
assert(dynamic_array.get_length()==1,'dynamic_array::length failed for non-empty array.');
fprintf('Success!\n\n');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Testing dynamic_array::concat...');
dynamic_array.concat([6,2,1]);
assert(isequal(dynamic_array.to_matlab_array(),[5,6,2,1]),'dynamic_array::pop failed.');
fprintf('Success!\n\n');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Testing dynamic_array::swap...');
dynamic_array.swap(1,4);
dynamic_array.swap(2,3);
assert(isequal(dynamic_array.to_matlab_array(),[1,2,6,5]),'dynamic_array::pop failed.');
try
    dynamic_array.set(1,5);
catch err
    disp(err.identifier);
    exception_thrown = true;
end
assert(exception_thrown,'dynamic_array::swap failed to generate an error for an index greater than its size');
exception_thrown = false;
try
    dynamic_array.set(0,4);
catch err
    disp(err.identifier);
    exception_thrown = true;
end
assert(exception_thrown,'dynamic_array::swap failed to generate an error for an index less than 1');
fprintf('Success!\n\n');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Checking ability to create distinct instances of dynamic_array');
dynamic_array_2 = create_dynamic_array;
assert(dynamic_array_2.is_empty(),'Failed to create distinct instance of dynamic_array')
fprintf('Success!\n\n');

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
disp('Testing insertion time compared to standard Matlab array (this may take up to a minute)...');
test_sizes = 15000:5000:75000;
array_results = [];

for i = 1:length(test_sizes);
    time_handle = tic;
    array = [];
    for j = 1:test_sizes(i)
        array = [array,j];
    end
    array_results(i) = toc(time_handle);
end

dynamic_array_results = [];


for i = 1:length(test_sizes);
    time_handle = tic;
    dynamic_array = create_dynamic_array;
    for j = 1:test_sizes(i)
        dynamic_array.push(j);
    end
    dynamic_array_results(i) = toc(time_handle);
end

figure
plot(test_sizes,array_results,'linewidth',2);
hold on
plot(test_sizes,dynamic_array_results,'r','linewidth',2);
xlabel('Array Size')
ylabel('Array Insertion Time (s)')
legend('Standard Array','Dynamic Array','Location','NorthWest')

disp(['Standard array cumulative time: ',num2str(sum(array_results)),' seconds'])
disp(['Dynamic array cumulative time: ',num2str(sum(dynamic_array_results)),' seconds'])

clear