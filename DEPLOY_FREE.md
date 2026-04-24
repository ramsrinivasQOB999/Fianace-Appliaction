# Free Deployment Guide

This project can be deployed 100% on free tiers using:

- Backend: Render (free web service)
- Database: Neon (free PostgreSQL)
- Frontend: Vercel (free static hosting)

## 1) Prepare GitHub

1. Push this repo to GitHub.
2. Make sure the backend code you want is in `backend` (lowercase) directory.

## 2) Create free PostgreSQL on Neon

1. Create a Neon project.
2. Create (or use default) database, for example `glow_business_board`.
3. Copy connection details:
   - host
   - port
   - db name
   - username
   - password

Example JDBC URL format:

`jdbc:postgresql://<host>:<port>/<db>?sslmode=require`

## 3) Deploy backend on Render

1. In Render, click **New +** -> **Blueprint**.
2. Select your GitHub repo. Render will detect `render.yaml`.
3. Set the required environment variables in Render service:

- `SPRING_PROFILES_ACTIVE=prod`
- `SPRING_DATASOURCE_URL=jdbc:postgresql://<host>:<port>/<db>?sslmode=require`
- `SPRING_DATASOURCE_USERNAME=<username>`
- `SPRING_DATASOURCE_PASSWORD=<password>`
- `JHIPSTER_SECURITY_AUTHENTICATION_JWT_BASE64_SECRET=<long-base64-secret>`
- `JHIPSTER_CORS_ALLOWED_ORIGINS=https://<your-frontend-domain>`

For JWT secret, you can use a long base64 value similar to:
`backend/src/main/resources/config/application-secret-samples.yml`

4. Deploy and wait until build finishes.
5. Verify backend health:
   - `https://<your-backend>.onrender.com/management/health`

## 4) Deploy frontend on Vercel

1. Import the same GitHub repo in Vercel.
2. Build settings:
   - Framework: Vite
   - Build command: `npm run build`
   - Output directory: `dist`
3. Add environment variables in Vercel:
   - `VITE_USE_BACKEND=1`
   - `VITE_API_BASE_URL=https://<your-backend>.onrender.com`
4. Deploy.

## 5) Final check

1. Open your Vercel URL.
2. Open browser devtools -> Network.
3. Confirm API calls go to your Render backend URL.
4. Test login and one create flow (for example create Business).

## Common gotchas

- If API fails with CORS: update `JHIPSTER_CORS_ALLOWED_ORIGINS` on Render.
- If backend fails DB connect: recheck Neon JDBC URL and password.
- If frontend still points to localhost: confirm Vercel env vars and redeploy.
