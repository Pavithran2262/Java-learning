package oops;

  class Vehicle {
        protected String brand;
        protected int year;

        public void start() {
            System.out.println("The vehicle has started.");
           }

        public void stop() {
            System.out.println("The vehicle has stopped.");
        }
  }
  class Car extends Vehicle {
        private int max_speed;

        public void setmax_speed(int speed) {
            max_speed = speed;
        }

        public int getmax_speed() {
            return max_speed;
        }
    }


