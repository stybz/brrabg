package bz.sty.brra.xml.marshallers.parsers;

import bg.registryagency.schemas.deedv2.DeedType;

/** Copied from Alfa */
@FunctionalInterface
public interface ParseMolMethod {
    String parseMolFromDeed(DeedType deedType);
}