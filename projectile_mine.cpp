#include <bits/stdc++.h>
#include <cmath>
#include <math.h>

#define g 9.8

float return_y_pos_mine(float init_v, float t, double theta){
  return sqrtf((init_v*init_v)*(t*t) + ((g*g)*(t*t*t*t))/4 - g*init_v*float(sin(theta))*(t*t*t));
}

int main(){

  float init_v, t, dt;
  t = 0;
  dt = 0.001;
  init_v = 9.8;
  double theta = 90;

  while(t < 3){
    std::cout << return_y_pos_mine(init_v, t, theta) << "  \n";
    t += dt;

  }

}
