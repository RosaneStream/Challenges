package rose.me.bank_operation_api.service;
import rose.me.bank_operation_api.domain.model.User;

public interface UserService {

  User findById(Long id);

  User create(User userToCreate);
}
