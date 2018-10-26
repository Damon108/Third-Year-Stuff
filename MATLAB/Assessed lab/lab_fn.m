function z  = lab_fn(x,y)
a= local_fn(x^2,y^2);
b = local_fn(x,y);
nested_fn();

function nested_fn()
z = a-b^2;
    end
end

function z  = local_fn(x,y)
    z = (x+y)/2;
end

