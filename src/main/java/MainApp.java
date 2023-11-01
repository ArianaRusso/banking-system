
import br.com.arianarusso.entities.Address;
import br.com.arianarusso.infra.SQLConnection;
import br.com.arianarusso.infra.mappers.AddressRowMapper;
import br.com.arianarusso.infra.mappers.EntityMapper;
import br.com.arianarusso.infra.repositories.AddressRepositoryImpl;
import br.com.arianarusso.infra.repositories.GenericRepositoryImpl;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.io.IOException;
import java.util.List;


public class MainApp {
    public static void main(String[] args) throws IOException {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        AddressRepositoryImpl addressRepository = container.instance().select(AddressRepositoryImpl.class).get();

        System.out.println(addressRepository.listAllAddress());

        weld.shutdown();

//        SQLConnection connection = new SQLConnection();
//        connection.getConnection();
//        System.out.println(connection);
//
//        EntityMapper<Address> addressMapper = new AddressRowMapper();
//
//        AddressRepositoryImpl addressRepository =
//                new AddressRepositoryImpl(new GenericRepositoryImpl<>(connection,addressMapper, "address"));
//
//        List<Address> addresses = addressRepository.listAllAddress();
//        System.out.println("Lista" + addresses);


    }
}
