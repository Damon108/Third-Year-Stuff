

function h = display_grayscale_image(img)
%DISPLAY_GRAYSCALE_IMAGE Summary of this function goes here
%   Detailed explanation goes here
h = image(img);
 

figure,image(img),axis off
colormap gray(256)
end

