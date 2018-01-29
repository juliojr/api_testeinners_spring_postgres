package br.com.curso.repository;

import br.com.curso.util.DefaultConnection;

@Repository
public class UserRepository extends JpaRepository<> {
	
	
	//private DefaultConnection defaultConnection;

//	public UserRepository() {
//		defaultConnection = new DefaultConnection();
//	}

	public List<UserModel> get() {
//		try {
//			PreparedStatement stm = defaultConnection
//					.getConnection()
//					.prepareStatement("SELECT * FROM c.usuario;"); //SELECT * FROM c.usuario;
//			List<UserModel> userEntities = new ArrayList<>();
//			ResultSet rs = stm.executeQuery();
//			while(rs.next()) {
//				userEntities.add(new UserModel(
//						rs.getInt(1),
//						rs.getString(2),
//						rs.getString(3),
//						rs.getString(4),
//						rs.getString(5)
//						));
//			}
//			
//			return userEntities;			
//			
//		} catch (SQLException e) {
//			return null;
//		}finally {
//			if(defaultConnection != null) {
//				defaultConnection.closeConnection();
//			}
//		}
//		
	}

}
