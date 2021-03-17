function deleteProduct(e){
    let id=e.val();
    $.ajax(
        {
            type:"DELETE",
            //tên API
            url:"/api/products/delete/"+ id,
            //xử lý khi thành công
            success: function (data) {
                e.parent().parent().remove();},
            error: function (){
                alert("failed to delete")
            }
        }
    )
}
function createProduct(){
let productName=$('#productName').val();
let productBrand=$('#productBrand').val();
let productCategory=$('#productCategory').val();
let newProduct ={
    name: productName,
    brand: productBrand,
    category:{
        id: productCategory
    }
}
$.ajax(
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newProduct),
        url:"/api/products/create",
        //xử lý khi thành công
        success: successHandler
    }
)
}
function successHandler(){
$.ajax({
type:"GET",
url: "/api/products",
success: function (data){
let content=`  <tr>
                <th>Name</th>
                <th>Brand</th>
                <th>Category</th>
                <th class="text-center">Action</th>
            </tr>`
    for (let i = 0; i < data.length; i++) {
        content+=`<tr><td>${data[i].name}</td>
<td>${data[i].brand}</td>
<td>${data[i].category.name}</td>
    <td class="text-center"><a class='btn btn-info btn-xs' " ><span class="glyphicon glyphicon-edit"></span> Edit</a>
                        <button onclick="deleteProduct($(this))" value="${data[i].id}"  class="btn btn-danger btn-xs"><span class="glyphicon glyphicon-remove"></span> Del</button></td>
</tr>`
document.getElementById("tableList").innerHTML=content;
    }
}
})
}
