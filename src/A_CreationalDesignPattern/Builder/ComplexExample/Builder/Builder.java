package A_CreationalDesignPattern.Builder.ComplexExample.Builder;

import A_CreationalDesignPattern.Builder.ComplexExample.Products.Parts.*;

public interface Builder {
    void setType(Type type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
