// Post API 호출
function postApi(url, params, successCallback, errorCallback) {
  $.ajax({
    type: 'POST',
    url: url,
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    },
    data: JSON.stringify(params),
    success: function (data) {
      if (typeof successCallback === 'function') {
        successCallback(data);
      }
    },
    error: function (err) {
      if (typeof errorCallback === 'function') {
        errorCallback(err);
      }
    }
  });
}

function onApiError(err) {
  alert(JSON.stringify(err));
}

function onApiSuccess(data) {
  alert(data.msg);
}
