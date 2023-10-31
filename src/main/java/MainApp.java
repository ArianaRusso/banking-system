import br.com.arianarusso.entities.Address;
import br.com.arianarusso.infra.PostgreSQLConnection;
import br.com.arianarusso.infra.mappers.AddressRowMapper;
import br.com.arianarusso.infra.mappers.EntityMapper;
import br.com.arianarusso.infra.repositories.AddressRepositoryImpl;
import br.com.arianarusso.infra.repositories.GenericRepositoryImpl;
import java.util.List;
import java.util.UUID;

public class MainApp {
    public static void main(String[] args) {

        PostgreSQLConnection connection = new PostgreSQLConnection();
        connection.getConnection();
        System.out.println(connection);

        EntityMapper<Address> addressMapper = new AddressRowMapper();

        AddressRepositoryImpl addressRepository =
                new AddressRepositoryImpl(new GenericRepositoryImpl<>(connection,addressMapper, "address"));

       List<Address> addresses = addressRepository.listAllAddress();
       System.out.println("Lista" + addresses);

        UUID id = UUID.fromString("1c3c25d9-2de3-4c3d-9c47-6e0ad365d3b4");
        Address address = addressRepository.findAddressById(id);
        System.out.println("Busca por id " + address);

        addressRepository.deleteAddressById(id);

        Address novoAddress = new Address
                (id, "123456", "Washington",
                        333, "Casa 10", "Valinhos", "SP", "Brasil");

        addressRepository.saveAddress(novoAddress);
        System.out.println("Nova lista: "+addressRepository.listAllAddress());

        Address addressToUpdate = new Address(id, "123456", "João",
                333, "Casa 10", "Valinhos", "SP", "Brasil");
        addressRepository.updateAddress(addressToUpdate, id);
        System.out.println("Lista após update: "+addressRepository.listAllAddress());
    }
}
