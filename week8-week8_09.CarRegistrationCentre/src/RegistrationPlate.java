
public class RegistrationPlate {
    // don't change the code which is already given to you

    // ATTENTION: the object variable types are final, meaning that their value cannot be changed!
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode) {
        this.regCode = regCode;
        this.country = country;
    }

    @Override
    public String toString() {
        return country + " " + regCode;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || (object.getClass() != this.getClass())) {
            return false;
        }
        RegistrationPlate compare = (RegistrationPlate) object;
        if (!compare.regCode.equals(this.regCode) || !compare.country.equals(this.country)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (this.regCode == null || this.country == null) {
            return -1;
        }
        return (regCode + country).hashCode();
    }

}
