function auto_threshold(img)
m =  mean(img(:))
img(img< m) = 0;
img(img> m) = 265;

figure, colormap gray(256), image(img), axis off;

end

