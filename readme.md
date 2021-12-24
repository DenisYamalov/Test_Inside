Written on Java 11.

Database - PostgreSQL 13.3
1. To run use docker load < test_inside_app.tar, and then start it
2. To register new user use http://localhost:8000/register method post
3. To generate token use http://localhost:8000/auth method post
4. To send messages use http://localhost:8000/user/say method post + Bearer token for authentication