package br.com.curso.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.model.ResultWithContentArrayModel;
import br.com.curso.model.UserModel;
import br.com.curso.repository.UserRepository;

@RestController
@RequestMapping(value="/user")
public class UserResource {

	@GetMapping()
	public ResultWithContentArrayModel<UserModel> get() {
		
		UserRepository userRepository = new UserRepository();		
		List<UserModel> users = userRepository.get();
		
		ResultWithContentArrayModel<UserModel> res = new ResultWithContentArrayModel<>();
		
		res.setCode(users != null ? 0 : 1); // tipo de retorno 0 = sucesso - nao tem nada a ver com o status code
		res.setMessage(users != null ? "usuarios retorno ok" : "erro retorno");
		res.setContent(users);
		
		return res;
	}
	

}
