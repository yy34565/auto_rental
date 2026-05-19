import requestHttp from "@/utils/request";
export default {
    // async delete(id) {
    //     return requestHttp.delete("/api/auth_role/" + id);
    // },
    // async save(data) {
    //     return requestHttp.post("/api/auth_role", data);
    // },
    // async update(data) {
    //     return requestHttp.put("/api/auth_role", data);
    // },
    async search(start, size, data) {
        // 使用反引号和 ${} 来动态插入变量
        const url = `/rental/role/${start}/${size}`;
        return requestHttp.post(url, data);
    },
     async save(data){
        return await requestHttp.post(`/rental/role`,data);
    },
    async update(data){
        return await requestHttp.put(`/rental/role`,data);
    },
    async hasUser(id){
        return await requestHttp.get(`/rental/role/hasUser/${id}`);
    },
    async delete(ids){
        return await requestHttp.delete(`/rental/role/${ids}`);
    },
    async permissionTree(param){
        return await requestHttp.get(`/rental/role/permissionTree`,param);
    },
    async assignPermission(roleId,permissionIds){
        return await requestHttp.get(`/rental/role/${roleId}/${permissionIds}`);
    },
    async list() {
        return await requestHttp.get(`/rental/role`);
    },
}
