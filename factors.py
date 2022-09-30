n = int(input("Enter any no: "))

no_of_factors = 0

for _ in range(1, n+1):
    if n % _ == 0:
        no_of_factors += 1
print(no_of_factors)
