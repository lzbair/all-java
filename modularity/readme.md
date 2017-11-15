Compile:
javac -d target\ --module-source-path modules\ --module spi
javac -d target\ --module-source-path modules\ --module toolkit
javac -d target\ --module-source-path modules\ --module shop

Run:
java --module-path target\ -m shop/com.ecommerce.Shop