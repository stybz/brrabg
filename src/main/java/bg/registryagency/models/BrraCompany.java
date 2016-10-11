package bg.registryagency.models;

import java.io.Serializable;

public class BrraCompany implements Serializable{
    private String name;
    private String mol;
    private String eik;
    private String address;

    BrraCompany() {

    }

    public static class Builder {
        private BrraCompany company;

        public Builder() {
            this.company = new BrraCompany();
        }

        public Builder name(String name) {
            this.company.name = name;
            return this;
        }

        public Builder mol(String mol) {
            this.company.mol = mol;
            return this;
        }

        public Builder eik(String eik) {
            this.company.eik = eik;
            return this;
        }

        public Builder address(String address) {
            this.company.address = address;
            return this;
        }

        public BrraCompany build() {
            return this.company;
        }
    }

    public String getName() {
        return name;
    }

    public String getMol() {
        return mol;
    }

    public String getEik() {
        return eik;
    }

    public String getAddress() {
        return address;
    }
}
