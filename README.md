# online-player

## nginx config

    server {
    
        listen      localhost:81;
    
            root path_to_this_project/online-player-ui/dist/;
    
        location /api/ {
            client_max_body_size 300M;
            proxy_set_header X-Forwarded-Host $host;
            proxy_set_header X-Forwarded-Server $host;
            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
            proxy_pass http://localhost:8080/api/;
        }
    }


## install dependencies

    npm install
    
    
## build UI

    webpack