# 前端页面

## 启动

在项目根目录启动 Spring Boot 后端（端口 8080）：

```powershell
./mvnw.cmd spring-boot:run
```

在另一个终端启动前端：

```powershell
cd frontend
npm.cmd install
npm.cmd run dev
```

浏览器打开 `http://localhost:5173/`。Vite 会把 `/api` 请求代理到后端的 `http://localhost:8080`。

页面上的按钮请求 `GET /api/time`，后端返回服务器当前时间。
