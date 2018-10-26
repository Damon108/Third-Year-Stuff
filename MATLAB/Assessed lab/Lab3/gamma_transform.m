function gamma_transform(img,gamma)
img = double(img);

value = max(img).* (img ./ max(img)) .^gamma;
 value = uint8(value)
figure, colormap gray(265), image(value), axis off
end

