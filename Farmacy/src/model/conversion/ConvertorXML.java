package model.conversion;

import model.IUser;

public interface ConvertorXML {

    IUser convertFromXML();

    void ConvertToXML(IUser user);
}
