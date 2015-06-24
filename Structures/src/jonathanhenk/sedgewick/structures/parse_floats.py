import matplotlib.pyplot as plt

x_data = []
y_data = []

with open("C:\\Users\\Jon\\algs4\\QSpeed.txt") as f:
	for line in f:
		numbers_str = line.split(',')
		x_data.append(float(numbers_str[1]))
		y_data.append(float(numbers_str[2]))
x_data = []
for x in range(0,100):
	x_data.append(x*10);

y_data = []
for x in range(0,100):
	y_data.append(x*30);


plt.loglog(xdata=x_data, ydata=y_data, linestyle='-')
plt.show()