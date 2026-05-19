import requestHttp from "@/utils/request";

export default {
    //   async delete(id) {
    //     return await requestHttp.delete("/rental/auth_user/" + id);
    //   },
    //   async hasChildren(id) {
    //     return await requestHttp.get("/rental/auth_user/hasChildren/" + id);
    //   },
    async selectRoleIdByUserId(id) {
        return await requestHttp.get(`/rental/user/role/${id}`);
    },
    async save(data) {
        return await requestHttp.post(`/rental/user`, data);
    },
    async search(start, size, data) {
        return await requestHttp.post(`/rental/user/${start}/${size}`, data);
    },
    async bindRole(userId, roleIds) {
        return await
            requestHttp.get(`/rental/user/bind/${userId}/${roleIds}`);
    }
}