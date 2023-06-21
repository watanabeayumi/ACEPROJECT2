$ pip install beautifulsoup4 

ort urllib
from bs4 import BeautifulSoup

// code : バーコード情報
def code_to_product_info(code):
    print('*********** start product_info ************')
    start_time = time.time()

    product_info = None
    client_id = '<client_id>'

    url = 'http://shopping.yahooapis.jp/ShoppingWebService/V1/itemSearch?appid={0}&jan={1}'.format(client_id, code)
    response = urllib.urlopen(url).read()
    soup = BeautifulSoup(response)
    res = soup.find_all('name') // nameタグを取得
    //ここから超雑
    if len(res) > 0:
        product_info = res[0]

    print 'proc_time {0:f} [ms] '.format((time.time() - start_time) * 1000)
    return product_info
    print('*********** end product_info ************')