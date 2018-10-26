function res = normalize_vector(v)

res = v/norm(v);
end

function n = norm(v)

n = sqrt(sum(v.^2));
end