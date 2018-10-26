%Create the sizes array
sizes = [1,10,100,1000,10000];
%Pre-allocate space for the result arrays (not strictly necessary, but good
%practice!).
loop_time = zeros(size(sizes));
vector_time = zeros(size(sizes));
%Loop through the sizes array, passing in sizes one-by-one.
for i = 1:length(sizes);
    loop_time(i) = time_execution_basic(@loop_based_fn,sizes(i));
    vector_time(i) = time_execution_basic(@vector_based_fn,sizes(i));
end

%Plot the results
figure,plot(sizes,loop_time,sizes,vector_time)
xlabel('size')
ylabel('time (s)')
legend('loop','vector','Location','NorthWest')

clear sizes loop_time vector_time i