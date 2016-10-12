package bz.sty.brra;

import bg.registryagency.schemas.deedv2.DeedType;
import bz.sty.brra.xml.marshallers.parsers.DeedTypeParser;
import bz.sty.brra.xml.marshallers.parsers.InvalidDeedException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Brra company with only {@link #eik}, {@link #name}, {@link #mol}, {@link #address}.
 * <p>
 * These companies are very useful for invoices.
 *
 * A lot of stuff came from Alfa.
 */
public class BrraCompanyShort implements Serializable {
    @Getter @Setter(AccessLevel.PRIVATE)
    private String eik;
    @Getter @Setter(AccessLevel.PRIVATE)
    private String name;
    @Getter @Setter(AccessLevel.PRIVATE)
    private String mol;
    @Getter @Setter(AccessLevel.PRIVATE)
    private String address;
    @Getter @Setter(AccessLevel.PRIVATE)
    private LocalDate dateLastModified;

    private BrraCompanyShort() {}

    public static BrraCompanyShort createInstance(DeedType dt, LocalDate date) throws InvalidDeedException {
        BrraCompanyShort company = new BrraCompanyShort();
        DeedTypeParser deedTypeParser = new DeedTypeParser(dt);

        company.setEik(deedTypeParser.getEik());
        company.setName(deedTypeParser.getName());
        company.setDateLastModified(date);
        company.setMol(deedTypeParser.getMol());
        company.setAddress(deedTypeParser.getAddress());

        return company;
    }

    public BrraCompanyShort updateCompanyData(BrraCompanyShort newCompanyData) {
        String address = newCompanyData.getAddress();
        if (address != null && !address.trim().isEmpty()) {
            this.address = address;
        }
        String name = newCompanyData.getName();
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
        String mol = newCompanyData.getMol();
        if (mol != null && !mol.trim().isEmpty()) {
            this.mol = mol;
        }
        LocalDate dateLastModified = newCompanyData.getDateLastModified();
        if (dateLastModified != null) {
            this.dateLastModified = dateLastModified;
        }
        return this;
    }
}