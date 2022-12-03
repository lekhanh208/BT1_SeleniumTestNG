# BT_SeleniumTestNG
BÀI TẬP 1 CHẠY TRÊN PROJECT MAVEN
(Bắt đầu từ bài học số 9 trở về sau)

- https://demo.activeitzone.com/ecommerce/login

- Add Category
       + Add hình sẵn vài tấm bằng tay trước khi chạy auto
       + Chú ý phần chọn hình: click Browse -> search tên hình add bằng tay -> click item hình -> Click Add button
- Sau khi add category xong trở về menu Category (trang list)
- Search category name vừa add
- Get cái Text của item đầu tiên cột Name dưới Table sau khi search xem đúng không (if else)

BÀI TẬP 2 VỀ GHI CHÚ TRONG TESTNG (Annotation)

- Tách code cũ ở BT Add Category ra theo các ghi chú (annotation):
(không dùng hàm main nữa)

+ Tách đoạn setup Driver ra riêng không để chung trong test case
+ Tách Login sẽ chạy trước mỗi test case
+ Optimize code chạy cho ổn định hơn (sleep, xpath)
+ Tập chạy code trên file suite XML
To enable screen reader support, press Ctrl+Alt+Z To learn about keyboard shortcuts, press Ctrl+slash

BÀI TẬP 3 VỀ ASSERT

THÊM ASSERT VÀO ADD CATEGORY ĐANG LÀM Ở BT2

- Kiểm tra Text của tất cả dialog
- Kiểm tra Text trên mỗi trang
- Kiểm tra giá trị item vừa add với Assert chứ ko dùng if else như BT1 nữa
To enable screen reader support, press Ctrl+Alt+Z To learn about keyboard shortcuts, press Ctrl+slash
 
BÀI TẬP 3 MỞ RỘNG

Làm thêm case Edit và Delete category

Gợi ý:
        + Edit thì gọi lại phần Add. Xong thực hiện tiếp tục lệnh nhấn button Edit...
        + Edit thì search lại check giá trị mới sau khi edit

        + Delete thì sau khi xoá xong cần check lại là element đó không tồn tại (chỉ trong buổi học)
To enable screen reader support, press Ctrl+Alt+Z To learn about keyboard shortcuts, press Ctrl+slash
 

 

 

