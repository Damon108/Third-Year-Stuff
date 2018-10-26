function y = loop_based_fn( ln )
    for i = 1:ln
        y(i) = i*cos(i) - sin(pi);
    end
end

function v = loop_based_fn_v (ln)
x= 1:ln;
v = x.*cos(x) - sin(pi);
end