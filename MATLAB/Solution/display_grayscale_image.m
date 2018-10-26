function h = display_grayscale_image( img )
    %Create a new figure window
    figure
    %Display the argument as an image in this figure window. Note that 'h',
    %the return value, is a "handle" through which we can alter the figure
    %after the function has returned.
    h = image(img);
    %Remove the axes from the figure window
    axis off
    %Set the correct colormap for 8-bit grayscale
    colormap gray(256)
end

