Compile:
javac -d target\ --module-source-path modules\ --module shop

Run:
java --module-path target\ -m shop/com.ecommerce.Shop


Archive:
jar --create --file archive/address.jar -C target\address\ .
jar --create --file archive/delivery.jar -C target\delivery\ .
jar --create --file archive/shop.jar --main-class com.ecommerce.Shop -C target\shop\ .

Run:
java --module-path archive\ -m shop