
import requestHttp from '@/utils/request'
//登录
export async function login(data) {
  return await requestHttp.login('/rental/user/login', data)
}
//获取用户信息
export async function getInfo() {
  return await requestHttp.get('/rental/auth/getInfo')
}




// export function logout() {
//   return request({
//     url: '/vue-element-admin/user/logout',
//     method: 'post'
//   })
// }
