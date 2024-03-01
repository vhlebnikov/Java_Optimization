import pandas as pd
import matplotlib.pyplot as plt

# Read CSV data
data = pd.read_csv('C:\\Study\\3_course\\Java_Optimization\\Task_1\\src\\main\\resources\\data.csv')

m = data['Max']
t = data['Total']
f = data['Free']
u = data['Used (total-free)']
o = data['Object']

# Plot graph
plt.plot(data.index, m, label='Max')
plt.plot(data.index, t, label='Total')
plt.plot(data.index, f, label='Free')
plt.plot(data.index, u, label='Used')
plt.plot(data.index, o, label='Object')
plt.xlabel('time')
plt.ylabel('bytes')
plt.legend()
plt.grid(True)
plt.savefig('memory.png', dpi=600)
