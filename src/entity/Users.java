package entity;

public class Users {
		private int uid;
		private String username;
		private String password;
		
		public Users() {
		}
		
		
		public Users(int uid, String username, String password) {
		
			this.uid = uid;
			this.username = username;
			this.password = password;
		}


		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}


		/**
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}


		/**
		 * @param password the password to set
		 * setter getter一定要用系统自己生成的 不然就无法接到表单传来的值
		 */
		public void setPassword(String password) {
			this.password = password;
		}
	
}
