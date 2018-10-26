%In file normalize_vector.m
%
%The main function should:
%   - Have the same name as the file: normalize_vector
%   - Expect a single input (here v)
%   - Return a single value (here res)
function res = normalize_vector(v)
%To normalize a vector, we divide each element by its norm.
%Note that we have used a local function to calculate the vector: not
%strictly necessary, but it clarifies our intent.
    res = v/norm(v);
end

function n = norm(v)
%A local function to calculate the norm of a given vector.
%The norm of a vector is the square root of the sum of its elements
%squared. In Matlab, this is easy to calculate.
    n = sqrt(sum(v.^2));
end

