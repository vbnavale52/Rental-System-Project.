import axios from 'axios';
const USER_API_BASE_URL = 'http://localhost:8080/api';
class UserServices {
     registerNewUser(newUser) {
          return axios.post(USER_API_BASE_URL + '/user/signup/', newUser);
     }
    async userProfile(newUser) {
          return await axios.post(USER_API_BASE_URL + '/user/user_profile',  newUser);
     }
     async fileUpload(file) {
          const config = {
               headers: {
                    'Content-Type': 'multipart/form-data'
               }
          }
          return await axios.post(USER_API_BASE_URL + '/upload', file, config);
     }
    async getUserProfile(userId) {
          return axios.get(USER_API_BASE_URL + '/user/user_profile/' + userId);
     }
}
export default new UserServices();
