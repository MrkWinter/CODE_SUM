def print_file_info(file_name):
    f = None
    try:
        f = open(file_name, "r", encoding="utf-8")
    except Exception as e:
        print("文件路径不存在")
    else:
        for i in f:
            print(i)
    finally:
        if f:
            f.close()


def append_to_file(file_name, data):
    f = open(file_name, "a", encoding="utf-8")
    f.write(data)
    f.close()
