function t = time_execution_basic( fn, n )
    %Start timing
    tic
    %Call the function with the provided argument
    fn(n);
    %Stop timing and return time elapsed.
    t = toc;
end