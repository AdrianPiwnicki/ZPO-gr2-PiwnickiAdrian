public class Zadanie3 {
    public class CarSpeed
    {
        private int maxSpeed;
        private String carName;

        public CarSpeed(int maxSpeed, String carName)
        {
            this.maxSpeed = maxSpeed;
            this.carName = carName;
        }

        public int getMaxSpeed()
        {
            return maxSpeed;
        }

        public String getCarName()
        {
            return carName;
        }
    }
}
