Compile:
javac -d target\ --module-source-path modules\ --module toolkit (Implementation provider should be compiled explicitly, since it's not Shop dependency)
javac -d target\ --module-source-path modules\ --module shop

Run:
java --module-path target\ -m shop/com.ecommerce.Shop


(can use -p short of --module-path)