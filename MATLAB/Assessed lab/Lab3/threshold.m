function threshold(img,thresh)

img(img<thresh) = 0;
img(img>thresh) = 265;
figure, colormap gray(256), image(img), axis off


end

