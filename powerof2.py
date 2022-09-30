power = int(input("Enter power of 2 to be calculated:"))
res = 1

for _ in range(power):
    res = res << 1
print(res)
