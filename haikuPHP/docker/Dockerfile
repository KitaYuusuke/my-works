FROM php:8-alpine
RUN docker-php-ext-install pdo pdo_mysql mysqli && \
    sed -i -e 's/;date.timezone =/date.timezone = "Asia\/Tokyo"/g' /usr/local/etc/php/php.ini-development && \
    sed -i -e 's/;date.timezone =/date.timezone = "Asia\/Tokyo"/g' /usr/local/etc/php/php.ini-production && \
    #sed -i -e 's/pdo_mysql.default_socket=/pdo_mysql.default_socket=\/var\/lib\/mysql\/mysql.sock/g' /usr/local/etc/php/php.ini-development && \
    #sed -i -e 's/pdo_mysql.default_socket=/pdo_mysql.default_socket=\/var\/lib\/mysql\/mysql.sock/g' /usr/local/etc/php/php.ini-production && \
    #sed -i -e 's/;extension=pdo_mysql/extension=pdo_mysql/g' /usr/local/etc/php/php.ini-development && \
    #sed -i -e 's/;extension=pdo_mysql/extension=pdo_mysql/g' /usr/local/etc/php/php.ini-production && \
    #sed -i -e 's/;extension_dir = "ext"/extension_dir = "\/usr\/local\/lib\/php\/extensions\/no-debug-non-zts-20220829"/g' /usr/local/etc/php/php.ini-development && \
    #sed -i -e 's/;extension_dir = "ext"/extension_dir = "\/usr\/local\/lib\/php\/extensions\/no-debug-non-zts-20220829"/g' /usr/local/etc/php/php.ini-production && \
    mv /usr/local/etc/php/php.ini-development /usr/local/etc/php/php.ini
RUN curl -sS https://getcomposer.org/installer | php && \
    mv composer.phar /usr/local/bin/composer