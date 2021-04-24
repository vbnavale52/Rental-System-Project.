import axios from 'axios';
const USER_API_BASE_URL = 'http://localhost:8080/api';
 class UserServices  
 {
    authenticateUser(loginRequest)
   {
        return axios.post(USER_API_BASE_URL + '/auth/signin/', loginRequest);
   }
  
}
export default new UserServices();
