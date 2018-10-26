function gamma_transform(img,gamma)
x = double(img);
y =double(max(img(:)));
img  = mpi.*(m/mpi).^img;
end

