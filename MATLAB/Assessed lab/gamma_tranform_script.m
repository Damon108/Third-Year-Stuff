picture = imread('peppers.bmp');
colormap gray(256);
grey_picture = rgb2gray(picture);

gamma_transform(grey_picture);
figure,image(grey_picture),axis off;