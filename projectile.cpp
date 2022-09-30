#include <bits/stdc++.h>
#include <math.h>
using namespace std;

#define g 9.77
#define dx 0.1f

float return_y_pos(float x, double theta, float u){
  return (x*tanf(theta) - (g*(x*x))/(2*(u*u)*(cosf(theta) * cosf(theta))));
}

int main(void) {
  float u, theta;
  cout << "Enter initial velocity of object: \n";
  cin >> u;
  cout << "Enter angle of projection: \n";
  cin >> theta;
  cout << "\n";

  float x = 0;
  while (x <= ((u*u)*(sinf(2*theta)))/g){
    cout << "The Vertical Displacement is: " << return_y_pos(x, theta, u);
    cout << "\n";
    x += dx;
  }


  return 0;
}
