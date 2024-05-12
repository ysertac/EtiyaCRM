package com.etiyacrm.customerservice.adapters;

import com.etiyacrm.customerservice.entities.IndividualCustomer;
import com.etiyacrm.customerservice.outservices.mernis.AWHKPSPublicSoap;
import org.springframework.stereotype.Service;

@Service
public class MernisServiceAdapter implements CustomerCheckService{
    @Override
    public boolean checkIfRealPerson(String nationalityId,
                                     String firstName,
                                     String lastName,
                                     int birthDate) throws Exception {
        AWHKPSPublicSoap client = new AWHKPSPublicSoap();
        return client.TCKimlikNoDogrula(
                Long.parseLong(nationalityId),
                firstName,
                lastName,
                birthDate);
    }
}
