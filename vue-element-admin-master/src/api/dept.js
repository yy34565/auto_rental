import requestHttp from '@/utils/request';
export default {
    async search(params) {
        return await requestHttp.post("/rental/dept", params)
    },
    async selectTree() {
        return await requestHttp.get("/rental/dept")
    },


}
