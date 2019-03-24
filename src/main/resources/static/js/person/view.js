// var tree = [[${tree}]];
// console.log(tree);
var temp = "";
$(function () {
    findChild(0);
    $("#genealogy_view").html(temp);
});

function findChild(id) {
    var first = true;
    for (var i = 0; i < tree.length; i++) {
        if (tree[i].pid == id) {
            if (first) {
                temp += '<ul>';
                first = false;
            }
            temp += '<li>' + personTitle(tree[i]);
            // temp += '<li><a href="#">' + tree[i].name + '</a>';
            findChild(tree[i].id)
            temp += '</li>';
        }
    }
    if (!first) {
        temp += '</ul>';
    }
}

function personTitle(per) {
    var str = '';
    str += '<a href="#" onclick="toAdd(' + per.id + ')" title="姓名：' + per.name +
        '\n性别：' + per.sexStr + '\n年龄：' + per.age +
        '\n电话：' + per.phone + '\n备注：' + per.remarks +
        '" >' + per.name + '</a>';
    return str;
}

function toAdd(pid) {
    window.location = "/person/add?pid="+pid;
}